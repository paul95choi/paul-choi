package Stock_service;

import Stock_dao.Stock_Dao_Impl;
import Stock_dto.Pagination;

public class Stock_ServiceImpl implements Stock_Service {

	@Override
	public Pagination getPagination(int c, int countPerPage) {
		// TODO Auto-generated method stub
		
		//getPagination 메서드는 페이지네이션 정보를 반환하는 기능을 구현한 메서드
				//매개변수로는 전체 항목 수 c와 페이지당 항목 수 countPerPage를 받는다. 
				//이 메서드는 Pagination 객체를 생성하고, StudentScoreDaoImpl 객체를 사용하여 전체 항목 수를 조회
				
				Pagination pagination = new Pagination(); //변수값을 세팅하거나 불러오기 위해 페이지네이션 객체 선언
				Stock_Dao_Impl a = new Stock_Dao_Impl(); //dao구현체의 함수를 불러오기 위해 객체 선언

				int totalLines = a.count(); //dao구현처에서 카운트 함수를 가져와 그 값을 반홚받아 totalLines 변수에 초기화
				//전체 항목 수와 페이지당 항목 수를 사용하여 총 페이지 수 totalPages를 계산
				int totalPages = (int) Math.ceil((double)totalLines / countPerPage); 
				
				int currentPage = c;  
				//현재 페이지 currentPage와 페이지당 항목 수 countPerPage를 사용하여 데이터베이스에서 조회할 행의 시작 위치 fromPT를 계산
				int fromPT = (currentPage - 1) * countPerPage + 1;
				//페이지네이션 한 블록이 담을 숫자 개수 선언
				int line_in_Block = 10;
				//행의 시작위치와 페이지당 항목수, 그리고 한 블록이 표현할 숫자를 사용하여 현재 블록 계산
				int currentBlock =(int) ((fromPT / countPerPage) / line_in_Block + 1); 
				//총 페이지를 한 블록이 담을 숫자 개수로 나눈값에 1을 더해 마지막 블록을 계산
				int lastBlock = (int)(totalPages/line_in_Block + 1);
				
				//만약 countPerPage값이 1보다 작은 값을 받는다면
				if (countPerPage < 1) {
				    countPerPage = 10; //countPerPage값을 10으로 설정
				}
				
				//만약 fromPT값이 0보다 작은 값을 받는다면
				if(fromPT < 0) {
				    fromPT = 1; //fromPT값을 1로 설정
				}
				
				if (fromPT > totalLines) { //만약 fromPT의 값이 전체 행 수보다 크다면
				    fromPT = ((int)(totalLines / 10 * 10) + 1); // 전체행수의 1의자리 숫자를 제외한 값에 1을 더하여 마지막 페이지를 계산
				}
				
				if(currentPage > totalPages){
					currentPage = totalPages;
				}
				/////////////////////////////////////////////////////////////////////////////////////////
				// 현재페이지
				//현재 페이지 currentPage의 값을 기준으로 페이지네이션 객체 pagination의 현재 페이지 C를 설정하는 부분
				//먼저, currentPage가 0보다 작거나 같을 경우, 현재 페이지를 1로 설정. 이는 페이지가 1보다 작을 수 없도록 보정하는 역할
				if (currentPage <= 0) {
					pagination.setC(1);
				//그렇지 않을 경우, currentPage가 총 페이지 수 totalPages보다 크다면 현재 페이지를 총 페이지 수로 설정. 
				//이는 마지막 페이지를 넘어가는 경우 현재 페이지를 마지막 페이지로 설정하여 보정하는 역할	
				} else { 
					if (currentPage > totalPages) {
						pagination.setC(totalPages);
					} else { //위의 두 조건을 모두 만족하지 않을 경우, 현재 페이지를 currentPage로 설정
						pagination.setC(currentPage);
					}
				}

				///////////////////////////////////////////////////////////////////////////////////////
				//스타트페이지
				//현재 페이지 currentPage를 기준으로 페이지 블록의 시작 페이지 startPage를 설정하는 부분
				//페이지 블록은 한 번에 표시되는 페이지의 범위를 의미. 
				//현재 페이지에서 1을 뺀 뒤, 페이지 블록의 크기인 line_in_Block으로 나눈 뒤 다시 line_in_Block을 곱하고 1을 더하여 
				//이를 통해 현재 페이지가 속한 페이지 블록의 시작 페이지를 계산
				int startPage = (currentPage - 1) / line_in_Block * line_in_Block + 1;
				//startPage가 0보다 작을 경우, 시작 페이지를 1로 설정하여 보정. 이는 시작 페이지가 1보다 작을 수 없도록 보장하는 역할
				if (startPage < 0) {
					startPage = 1;
				}
				//pagination 객체의 시작 페이지 S에 계산된 시작 페이지 값을 설정
				pagination.setS(startPage);


				///////////////////////////////////////////////////////////////////////////////////////
				//엔드페이지
				//페이지 블록의 마지막 페이지 endPage를 설정하는 부분
				//endPage는 페이지 블록의 시작 페이지 startPage에 페이지 블록의 크기 line_in_Block을 더한 뒤 1을 뺀 값과 
				//전체 페이지 수 totalPages 중 작은 값을 선택. 이를 통해 현재 페이지가 속한 페이지 블록의 끝 페이지가 계산됨.
				//Math.min() 함수를 사용하여 두 값 중 작은 값을 선택하여 endPage에 할당. 
				//이를 통해 현재 페이지가 속한 페이지 블록의 끝 페이지가 전체 페이지 수를 넘어가지 않도록 보장
				int endPage = Math.min(totalPages, startPage + line_in_Block - 1);
				//pagination 객체의 끝 페이지 E에 계산된 마지막 페이지 값을 설정
				//이를 통해 페이지 블록의 끝 페이지가 유효한 범위 내에서 설정되도록 보장
				pagination.setE(endPage);


				///////////////////////////////////////////////////////////////////////////////////////
				  //현재 페이지에서 10을 뺀 값을 이전 페이지로 설정
				  int previousPage = currentPage - 10;
				  //만약 현재 페이지가 전체 페이지 수(totalPages)보다 크다면, 이전 페이지를 전체 페이지 수에서 10을 뺀 값으로 설정. 
				  //이렇게 함으로써 이전 페이지를 현재 페이지보다 작은 값으로 유지
				  if(currentPage > totalPages) {
						pagination.setP(totalPages - 10);
					} else { //그렇지 않은 경우, 이전 페이지가 0보다 작거나 같은지 확인
						if (previousPage <= 0) {
							//만약 이전 페이지가 0보다 작거나 같다면, 이전 페이지를 -1로 설정. 
							//이렇게 함으로써 이전 페이지가 유효한 값인지 확인할 수 있다. 
					        pagination.setP(-1); // If the previous page is less than or equal to 0, set -1
					    } else { //그렇지 않은 경우, 이전 페이지를 이전 페이지로 설정. 이를 통해 이전 페이지 값이 유효한 범위 내에서 설정되도록 보장
					        pagination.setP(previousPage);
					    }
					}
				    

				///////////////////////////////////////////////////////////////////////////////////////
				 // 처음 페이지 pp
				  //만약 현재 시작 페이지(pagination.getS())가 1보다 크다면, 첫 번째 페이지를 1로 설정. 
				  //이렇게 함으로써 이전 블록으로 이동하는 링크를 첫 번째 페이지로 설정
				    if (pagination.getS() > 1) {
				        pagination.setPp(1); 
				    } else {//그렇지 않은 경우, 현재 시작 페이지가 이미 1인 경우이므로 이전 블록으로 이동하는 링크를 사용할 수 없다. 
				    	//따라서 -1을 설정하여 이전 블록으로 이동하는 링크를 비활성화.
				        pagination.setPp(-1); 
				    }

				///////////////////////////////////////////////////////////////////////////////////////

				
				// 다음페이지 n
				//현재 페이지(pagination.getC())에서 10을 더하여 다음 페이지를 계산
				int nextPage = pagination.getC() + 10;
				//현재 블록이 마지막 블록(currentBlock == lastBlock)인 경우, 다음 페이지로 이동할 수 없으므로 -
				//1을 설정하여 다음 페이지로 이동하는 링크를 비활성화
				if (currentBlock >= lastBlock) {
					pagination.setN(-1);
				//그렇지 않은 경우, 다음 페이지가 전체 페이지 수를 초과하지 않는지 확인하고, 초과하지 않는 경우 다음 페이지를 설정	
				} else {
					if (nextPage > totalPages) {
						pagination.setN(totalPages);
					} else {
						pagination.setN(nextPage);
					}
				}


				///////////////////////////////////////////////////////////////////////////////////////
				// 마지막페이지 nn
				//마지막 페이지(pagination.getE())와 전체 페이지 수(totalPages)를 비교
				//만약 마지막 페이지와 전체 페이지 수가 일치하는 경우, 다음 다음 페이지(pagination.setNn())로 이동할 수 없으므로 
				//-1을 설정하여 해당 링크를 비활성화.
				if (pagination.getE() >= totalPages) {
					pagination.setNn(-1);
				} else { //그렇지 않은 경우, 다음 다음 페이지가 존재하므로 전체 페이지 수(totalPages)를 설정
					//그렇지 않은 경우, 다음 다음 페이지가 존재하므로 전체 페이지 수(totalPages)를 설정
					pagination.setNn(totalPages);
				}
				
				//설정된 pagination 객체를 반환
				return pagination;

			}

}
