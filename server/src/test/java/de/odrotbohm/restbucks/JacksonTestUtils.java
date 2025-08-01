/*
 * Copyright 2015-2023 the original author or authors.
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
package de.odrotbohm.restbucks;

import de.odrotbohm.restbucks.JacksonCustomizations;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.Module;

/**
 * Helper to expose custom Jackson modules for unit tests.
 *
 * @author Oliver Gierke
 */
public class JacksonTestUtils extends JacksonCustomizations {

	public static Set<Module> getModules(Map<Class<?>, Class<?>> mixins) {
		return Set.of(new MoneyModule());
	}
}
