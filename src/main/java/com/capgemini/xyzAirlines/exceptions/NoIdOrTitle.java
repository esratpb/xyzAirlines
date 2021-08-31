package com.capgemini.xyzAirlines.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason="No Airplain with that Identification Plate found")
public class NoIdOrTitle extends RuntimeException{
}
