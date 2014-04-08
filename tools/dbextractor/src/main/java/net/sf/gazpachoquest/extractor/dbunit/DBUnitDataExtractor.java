/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.extractor.dbunit;

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
import org.dbunit.dataset.xml.FlatXmlWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extracts a DBUnit flat XML dataset from a database.
 * 
 * @author Bill Siggelkow
 */
public class DBUnitDataExtractor {

    private static final Logger logger = LoggerFactory.getLogger(DBUnitDataExtractor.class);
    /**
     * A regular expression that is used to get the table name from a SQL 'select' statement. This pattern matches a
     * string that starts with any characters, followed by the case-insensitive word 'from', followed by a table name of
     * the form 'foo' or 'schema.foo', followed by any number of remaining characters.
     */
    // private static final Pattern TABLE_MATCH_PATTERN =
    // Pattern.compile(".*\\s+from\\s+(\\w+(\\.\\w+)?).*",
    // Pattern.CASE_INSENSITIVE);
    private static final Pattern TABLE_MATCH_PATTERN = Pattern.compile("from\\s(?<tableName>\\w+)");
    private String dataSetName = "dbunit-dataset.xml";
    private DataSource dataSource;
    private Map dbUnitFeatures;
    private Map dbUnitProperties;
    private List<String> queryList;

    private String schema;
    private List<String> tableList;

    /**
     * Performs the extraction. If no tables or queries are specified, data from entire database will be extracted.
     * Otherwise, a partial extraction will be performed.
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

                // dependent tables database export: export table X and all
                // tables that
                // have a PK which is a FK on X, in the right order for
                // insertion
                String[] depTableNames = TablesDependencyHelper.getAllDependentTables(connection, "study");
                IDataSet depDataset = connection.createDataSet(depTableNames);

                FlatXmlWriter datasetWriter = new FlatXmlWriter(new FileOutputStream("target/dependents.xml"));
                datasetWriter.write(depDataset);

            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        logger.info("Completed extraction to '" + dataSetName + "'.");
    }

    /**
     * Name of the XML file that will be created. Defaults to <code>dbunit-dataset.xml</code>.
     * 
     * @param name
     *            file name.
     */
    public void setDataSetName(final String name) {
        dataSetName = name;
    }

    /**
     * The data source of the database from which the data will be extracted. This property is required.
     * 
     * @param ds
     */
    public void setDataSource(final DataSource ds) {
        dataSource = ds;
    }

    public void setDbUnitFeatures(final Map dbUnitFeatures) {
        this.dbUnitFeatures = dbUnitFeatures;
    }

    public void setDbUnitProperties(final Map dbUnitProperties) {
        this.dbUnitProperties = dbUnitProperties;
    }

    /**
     * List of SQL queries (i.e. 'select' statements) that will be used executed to retrieve the data to be extracted.
     * If the table being queried is also specified in the <code>tableList</code> property, the query will be ignored
     * and all rows will be extracted from that table.
     * 
     * @param list
     *            of SQL queries.
     */
    public void setQueryList(final List<String> list) {
        queryList = list;
    }

    /**
     * Set the schema.
     * 
     * @param schema
     */
    public void setSchema(final String schema) {
        this.schema = schema;
    }

    /**
     * List of table names to extract data from.
     * 
     * @param list
     *            of table names.
     */
    public void setTableList(final List<String> list) {
        tableList = list;
    }

    private void addQueries(final QueryDataSet dataSet) throws AmbiguousTableNameException {
        if (queryList == null) {
            return;
        }
        for (Object element : queryList) {
            String query = (String) element;
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

    private void addTables(final QueryDataSet dataSet) throws AmbiguousTableNameException {
        if (tableList == null) {
            return;
        }
        for (Object element : tableList) {
            String table = (String) element;
            dataSet.addTable(table);
        }
    }

    private void configConnection(final DatabaseConnection conn) {
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
}
