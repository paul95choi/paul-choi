package Stock_dao;

import java.util.List;

import Stock_domain.Stock;

public interface Stock_Dao {
	Stock allView(Stock stock);

	List<Stock> selectAll(int page, int countPerPage);

	Stock insert(Stock stock);

	Stock write(Stock stock);

	Stock update(int id, Stock stock);

	Stock delete(int id, Stock stock);

	List<Stock> OneView(int id, Stock stock);

	public int count();
	public String date();

	int maxCount();

	String getCreateDate();
	Stock insertrecord(Stock stock);
	
	
}
