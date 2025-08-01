/*
 * Copyright 2012-2019 the original author or authors.
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
package de.odrotbohm.restbucks.payment;

import static org.assertj.core.api.Assertions.*;

import de.odrotbohm.restbucks.AbstractIntegrationTest;
import de.odrotbohm.restbucks.payment.CreditCard;
import de.odrotbohm.restbucks.payment.CreditCardNumber;
import de.odrotbohm.restbucks.payment.CreditCards;

import java.time.Month;
import java.time.Year;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Integration tests for {@link CreditCards}.
 *
 * @author Oliver Gierke
 */
class CreditCardsIntegrationTest extends AbstractIntegrationTest {

	@Autowired CreditCards creditCards;

	@Test
	void createsCreditCard() {

		CreditCard creditCard = creditCards.save(createCreditCard());

		Optional<CreditCard> result = creditCards.findByNumber(creditCard.getNumber());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get()).isEqualTo(creditCard);
	}

	public static CreditCardNumber createCreditCardNumber() {
		return CreditCardNumber.of("4321");
	}

	public static CreditCard createCreditCard() {
		return new CreditCard(createCreditCardNumber(), "Oliver Gierke", Month.DECEMBER, Year.now().plusYears(1));
	}
}
