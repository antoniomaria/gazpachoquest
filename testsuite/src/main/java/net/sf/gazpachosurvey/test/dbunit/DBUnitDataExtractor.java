package net.sf.gazpachosurvey.test.dbunit;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;


import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extracts a DBUnit flat XML dataset from a database.
 * 
 * @author Bill Siggelkow
 */
public class DBUnitDataExtractor {

    private DataSource dataSource;
    private String dataSetName = "dbunit-dataset.xml";
    private List queryList;
    private List tableList;
    private Map dbUnitProperties;
    private Map dbUnitFeatures;
    private String schema;

    /**
     * A regular expression that is used to get the table name from a SQL
     * 'select' statement. This pattern matches a string that starts with any
     * characters, followed by the case-insensitive word 'from', followed by a
     * table name of the form 'foo' or 'schema.foo', followed by any number of
     * remaining characters.
     */
    private static final Pattern TABLE_MATCH_PATTERN = Pattern.compile(".*\\s+from\\s+(\\w+(\\.\\w+)?).*",
            Pattern.CASE_INSENSITIVE);
    private static final Logger logger = LoggerFactory.getLogger(DBUnitDataExtractor.class);
	

    /**
     * The data source of the database from which the data will be extracted.
     * This property is required.
     * 
     * @param ds
     */
    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    /**
     * Set the schema.
     * 
     * @param schema
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * Name of the XML file that will be created. Defaults to
     * <code>dbunit-dataset.xml</code>.
     * 
     * @param name
     *            file name.
     */
    public void setDataSetName(String name) {
        dataSetName = name;
    }

    /**
     * Performs the extraction. If no tables or queries are specified, data from
     * entire database will be extracted. Otherwise, a partial extraction will
     * be performed.
     * 
     * @throws Exception
     */
    public void extract() throws Exception {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            logger.info("Beginning extraction from '" + conn.toString() + "'.");
            IDatabaseConnection connection = new DatabaseConnection(conn, schema);
            configConnection((DatabaseConnection) connection);
            if (tableList != null || queryList != null) {
                // partial database export
                QueryDataSet partialDataSet = new QueryDataSet(connection);
                addTables(partialDataSet);
                addQueries(partialDataSet);
                FlatXmlDataSet.write(partialDataSet, new FileOutputStream(dataSetName));
            } else {
                // full database export
                IDataSet fullDataSet = connection.createDataSet();
                FlatXmlDataSet.write(fullDataSet, new FileOutputStream(dataSetName));
                

                // dependent tables database export: export table X and all tables that
                // have a PK which is a FK on X, in the right order for insertion
                String[] depTableNames = 
                  TablesDependencyHelper.getAllDependentTables( connection, "survey_instance" );
                IDataSet depDataset = connection.createDataSet( depTableNames );
                FlatXmlDataSet.write(depDataset, new FileOutputStream("target/dependents.xml")); 
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        logger.info("Completed extraction to '" + dataSetName + "'.");
    }

    /**
     * List of table names to extract data from.
     * 
     * @param list
     *            of table names.
     */
    public void setTableList(List list) {
        tableList = list;
    }

    /**
     * List of SQL queries (i.e. 'select' statements) that will be used executed
     * to retrieve the data to be extracted. If the table being queried is also
     * specified in the <code>tableList</code> property, the query will be
     * ignored and all rows will be extracted from that table.
     * 
     * @param list
     *            of SQL queries.
     */
    public void setQueryList(List list) {
        queryList = list;
    }

    public void setDbUnitFeatures(Map dbUnitFeatures) {
        this.dbUnitFeatures = dbUnitFeatures;
    }

    public void setDbUnitProperties(Map dbUnitProperties) {
        this.dbUnitProperties = dbUnitProperties;
    }

    private void configConnection(DatabaseConnection conn) {
        DatabaseConfig config = conn.getConfig();
        if (dbUnitProperties != null) {
            for (Iterator k = dbUnitProperties.entrySet().iterator(); k.hasNext();) {
                Map.Entry entry = (Map.Entry) k.next();
                String name = (String) entry.getKey();
                Object value = entry.getValue();
                config.setProperty(name, value);
            }
        }
        if (dbUnitFeatures != null) {
            for (Iterator k = dbUnitFeatures.entrySet().iterator(); k.hasNext();) {
                Map.Entry entry = (Map.Entry) k.next();
                String name = (String) entry.getKey();
                boolean value = Boolean.valueOf((String) entry.getValue()).booleanValue();
                // config.setFeature(name, value);
                config.setProperty(name, value);
            }
        }
    }

    private void addTables(QueryDataSet dataSet) throws AmbiguousTableNameException {
        if (tableList == null) {
            return;
        }
        for (Iterator k = tableList.iterator(); k.hasNext();) {
            String table = (String) k.next();
            dataSet.addTable(table);
        }
    }

    private void addQueries(QueryDataSet dataSet) throws AmbiguousTableNameException {
        if (queryList == null) {
            return;
        }
        for (Iterator k = queryList.iterator(); k.hasNext();) {
            String query = (String) k.next();
            Matcher m = TABLE_MATCH_PATTERN.matcher(query);
            if (!m.matches()) {
                logger.warn("Unable to parse query. Ignoring '" + query + "'.");
            } else {
                String table = m.group(1);
                // only add if the table has not been added
                if (tableList != null && tableList.contains(table)) {
                    logger.warn("Table '" + table + "' already added. Ignoring '" + query + "'.");
                } else {
                    dataSet.addTable(table, query);
                }
            }
        }
    }
}