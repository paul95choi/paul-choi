package Web_Board_service;

import Web_Board_dto.Pagination;

public interface Web_Board_Service {
	
	Pagination getPagination(int c, int countPerPage);
	
}
