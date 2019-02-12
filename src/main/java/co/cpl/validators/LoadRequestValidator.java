package co.cpl.validators;

import co.cpl.dto.LoadRequestDto;
import co.cpl.enums.Codes;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

// This is an example of how to declare constants
// please build your own constants based on this
@Component
public class LoadRequestValidator extends BaseValidator implements Validator {

    /*
     * This method validates the login data
     *
     * @return void no value is returning.
     */
    @Override
    public void validate(Object target, Errors errors) {

        LoadRequestDto loadRequest = (LoadRequestDto) target;
        if (Objects.isNull(loadRequest.getBuyer()) || StringUtils.isEmpty(loadRequest.getBuyer().getId())) {
            errors.rejectValue("buyer", Codes.BUYER_CANNOT_BE_NULL.getErrorCode());
        }

        if (Objects.isNull(loadRequest.getAmount())) {
            errors.rejectValue("amount", Codes.AMOUNT_CANNOT_BE_NULL.getErrorCode());
        }

        if (StringUtils.isEmpty(loadRequest.getCurrency())) {
            errors.rejectValue("currency", Codes.CURRENCY_CANNOT_BE_NULL.getErrorCode());
        }

        if (StringUtils.isEmpty(loadRequest.getMethod())) {
            errors.rejectValue("amount", Codes.METHOD_CANNOT_BE_NULL.getErrorCode());
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return LoadRequestDto.class.equals(clazz);
    }
}
