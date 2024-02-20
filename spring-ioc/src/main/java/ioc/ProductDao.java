package ioc;

/**
 * 상품정보의 저장,조회,변경 작업에 대한 표준을 정의한다.
 */
public interface ProductDao {
	
	void insertProduct();
	void getProduct();
	void updateProduct();

}
