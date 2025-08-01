/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.odrotbohm.restbucks.order.web;

import de.odrotbohm.restbucks.order.Order;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

/**
 * Event listener to reject {@code DELETE} requests to Spring Data REST.
 *
 * @author Oliver Gierke
 */
@Component
class OrderControllerEventListener extends AbstractRepositoryEventListener<Order> {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.rest.repository.context.AbstractRepositoryEventListener#onBeforeDelete(java.lang.Object)
	 */
	@Override
	protected void onBeforeDelete(Order order) {

		if (order.isPaid()) {
			throw new OrderAlreadyPaid();
		}
	}
}
