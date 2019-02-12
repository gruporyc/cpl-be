package co.cpl.utilities;

import co.cpl.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class CheckCatalogs {

    public static Status checkStatus(long status) {
        for (Status s : Status.values()) {
            if (s.ordinal() == status) return s;
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Status not allowed");
    }
}
