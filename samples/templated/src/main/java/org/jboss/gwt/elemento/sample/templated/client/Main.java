/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.gwt.elemento.sample.templated.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import org.jboss.gwt.elemento.sample.common.TodoItemRepository;

import static elemental2.dom.DomGlobal.document;

public class Main implements EntryPoint {

    @Override
    public void onModuleLoad() {
        TodoItemRepository repository = new TodoItemRepository();
        ApplicationElement application = ApplicationElement.create(repository);

        document.body.appendChild(application.element());
        document.body.appendChild(FooterElement.create().element());

        History.addValueChangeHandler(event -> application.filter(event.getValue()));
        History.fireCurrentHistoryState();
    }
}
