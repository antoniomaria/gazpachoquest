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
package net.sf.gazpachoquest.test.dbunit.support;

import java.io.InputStream;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.core.io.Resource;

import com.github.springtestdbunit.dataset.FlatXmlDataSetLoader;

public class ColumnDetectorXmlDataSetLoader extends FlatXmlDataSetLoader {

    @Override
    protected IDataSet createDataSet(Resource resource) throws Exception {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        InputStream inputStream = resource.getInputStream();
        try {
            return builder.build(inputStream);
        } finally {
            inputStream.close();
        }
    }
}
