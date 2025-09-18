package com.bookstore.main.common.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDto<T> {
	private String message;
	private int status;
	private T data;

	public ApiResponseDto(String message, int status) {
		this.message = message;
		this.status = status;
	}
}