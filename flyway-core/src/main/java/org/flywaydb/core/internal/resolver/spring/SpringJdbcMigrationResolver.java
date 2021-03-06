/*
 * Copyright 2010-2017 Boxfuse GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.core.internal.resolver.spring;

import org.flywaydb.core.api.MigrationType;
import org.flywaydb.core.api.configuration.FlywayConfiguration;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.flywaydb.core.internal.resolver.JavaMigrationResolver;
import org.flywaydb.core.internal.util.Locations;
import org.flywaydb.core.internal.util.scanner.Scanner;

/**
 * Migration resolver for Spring Jdbc migrations. The classes must have a name like V1 or V1_1_3 or V1__Description
 * or V1_1_3__Description.
 */
public class SpringJdbcMigrationResolver extends JavaMigrationResolver<SpringJdbcMigration, SpringJdbcMigrationExecutor> {
    /**
     * Creates a new instance.
     *
     * @param locations     The base packages on the classpath where to migrations are located.
     * @param scanner       The Scanner for loading migrations on the classpath.
     * @param configuration The configuration to inject (if necessary) in the migration classes.
     */
    public SpringJdbcMigrationResolver(Scanner scanner, Locations locations, FlywayConfiguration configuration) {
        super(scanner, locations, configuration);
    }

    @Override
    protected String getMigrationTypeStr() {
        return "Spring JDBC";
    }

    @Override
    protected Class<SpringJdbcMigration> getImplementedInterface() {
        return SpringJdbcMigration.class;
    }

    @Override
    protected SpringJdbcMigrationExecutor createExecutor(SpringJdbcMigration migration) {
        return new SpringJdbcMigrationExecutor(migration);
    }

    @Override
    protected MigrationType getMigrationType(



    ) {
        return



                        MigrationType.SPRING_JDBC;
    }
}