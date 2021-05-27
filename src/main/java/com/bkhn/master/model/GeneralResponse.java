package com.bkhn.master.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponse<T> {
	private static final long serialVersionUID = 1L;
	private T data;
}
