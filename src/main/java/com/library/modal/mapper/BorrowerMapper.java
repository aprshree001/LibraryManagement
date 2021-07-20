package com.library.modal.mapper;

import com.library.modal.BorrowEntity;

import dto.BorrowRequestDto;

public class BorrowerMapper {

	public static BorrowEntity toBorrow(BorrowRequestDto requestDto) {

		BorrowEntity borrow = new BorrowEntity();
		borrow.setBookId(requestDto.getBookid());
		borrow.setUserId(requestDto.getUserid());
		borrow.setNoOfBook(requestDto.getQuantity());
		return borrow;

	}

}
