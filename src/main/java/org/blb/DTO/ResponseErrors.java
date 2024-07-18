package org.blb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseErrors {
        private final String fieldName;
        private final String message;


}
