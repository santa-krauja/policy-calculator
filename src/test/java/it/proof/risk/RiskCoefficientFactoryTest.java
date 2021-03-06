package it.proof.risk;

import it.proof.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RiskCoefficientFactoryTest {

    private final RiskCoefficientDefinitions riskCoefficientFactory = new RiskCoefficientDefinitions();

    @ParameterizedTest
    @EnumSource(RiskType.class)
    void getCoefficient(RiskType riskType) {
        assertNotNull(riskCoefficientFactory.getCoefficients(riskType));
    }

    @Test
    void getCoefficient_throwsException() {
        assertThrows(ValidationException.class, () -> riskCoefficientFactory.getCoefficients(null));
    }
}