/*
 * Copyright 2021 the original author or authors.
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

import de.odrotbohm.restbucks.drinks.Drink.DrinkIdentifier;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;
import org.springframework.lang.Nullable;

/**
 * @author Oliver Drotbohm
 */
public interface Drinks extends CrudRepository<Drink, DrinkIdentifier> {

	@Nullable
	Drink findByName(String name);

	Streamable<Drink> findAll(Sort sort);

	Streamable<Drink> findByNameContaining(String name, Sort sort);
}
