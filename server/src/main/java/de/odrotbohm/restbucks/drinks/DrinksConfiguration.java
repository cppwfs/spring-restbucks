/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.odrotbohm.restbucks.drinks;

import javax.money.MonetaryAmount;

import org.springframework.boot.jackson.JsonMixin;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Customizations for the drinks module.
 *
 * @author Oliver Drotbohm
 */
@Configuration(proxyBeanMethods = false)
class DrinksConfiguration {

	@JsonMixin(Drink.class)
	static abstract class DrinkMixin {

		@JsonCreator
		public DrinkMixin(String name, Milk milk, Size size, MonetaryAmount price) {}
	}
}
