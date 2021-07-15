package com.library.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.library.dao.BorrowRepo;
import com.library.exception.LimitViolationException;
import com.library.modal.Borrow;
import com.library.service.BorrowServiceInterface;

import dto.UserRequestdto;

public class BorroServiceImpl  implements BorrowServiceInterface{
	
	@Autowired
	BorrowRepo borrowRepo;
	
	
	

	public Integer getUserTotalNoOfBooks(UserRequestdto userrequest) {
		
		
		
	
		
		return 0;
	}

	@Override
	public Integer findNoOfBookByUserId(String userId) {
		// TODO Auto-generated method stub
		borrowRepo.findNoOfBookByUserId(userId);
		
		return null;
	}

	@Override
	public Integer findBookAlreadyAssignedOrNot(String userId, String bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Borrow addBookToBorrowList(UserRequestdto userrequest) {
		
		
		Integer existOrNot = findBookAlreadyAssignedOrNot(userrequest.getUserid(),userrequest.getBookid());
		
		if(existOrNot.equals(1)) {
			throw new LimitViolationException("User already has one copy of the book.");
		}
		else {
			
			Integer countOfBookOfUser = findNoOfBookByUserId(userrequest.getUserid());
			if(countOfBookOfUser < 2) {
				
				
				
				Borrow borrow = new Borrow();
				borrow.setUserId(userrequest.getUserid());
				borrow.setBookId(userrequest.getBookid());
				borrow.setNo_of_book(userrequest.getQuantity());
				
				
				Borrow response =  borrowRepo.save(borrow);
				
				
			return response;
				
			}
			
			else {
				
				throw new LimitViolationException("User can reserve maximum two books.");
				
			}
			
			
		}
		
		
		
	
	}

}
