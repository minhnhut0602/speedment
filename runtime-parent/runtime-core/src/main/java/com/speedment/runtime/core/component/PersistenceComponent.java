/**
 *
 * Copyright (c) 2006-2016, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.runtime.core.component;

import com.speedment.common.injector.annotation.InjectKey;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.exception.SpeedmentException;
import com.speedment.runtime.core.manager.Persister;
import com.speedment.runtime.core.manager.Remover;
import com.speedment.runtime.core.manager.Updater;

/**
 * The {@code PersistanceComponent} handles persisting, updating and deleting 
 * entities from a remote store, for an example a database or an in-memory grid.
 * There can be multiple specialized interfaces that expose more methods to this
 * component.
 *
 * @author  Emil Forslund
 * @since   3.0.1
 */
@InjectKey(PersistenceComponent.class)
public interface PersistenceComponent {

    <ENTITY> Persister<ENTITY> persister(TableIdentifier<ENTITY> tableIdentifier) throws SpeedmentException;
    
    <ENTITY> Updater<ENTITY> updater(TableIdentifier<ENTITY> tableIdentifier) throws SpeedmentException;
    
    <ENTITY> Remover<ENTITY> remover(TableIdentifier<ENTITY> tableIdentifier) throws SpeedmentException;
    
}