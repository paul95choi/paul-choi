package Stock_service;

import Stock_dto.Pagination;

public interface Stock_Service {

	Pagination getPagination(int c, int countPerPage);
}
