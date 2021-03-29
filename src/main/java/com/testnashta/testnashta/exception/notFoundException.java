package com.testnashta.testnashta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class notFoundException extends Exception{

	public notFoundException(String pesan) {
		super(pesan);
	}
}
