package ioc;

/**
 * ProductService는 상품정보를 등록, 조회, 수정한다.
 * ProductService는 상품정보를 등록, 조회, 수정하기 위해서 ProductDao인터페이스를 구현한 객체가 필요하다.
 */
public class ProductService {
	
	// ProductJdbcDao dao1 = new ProductJdbcDao();
	// ProductDao dao2 = new ProductJdbcDao();
	
	// 1. 위처럼 객체를 생성하지 않고 연결할 변수만 선언한다.
	// ProductDao의 한 종류이지만 어떤 객체가 조립되었는지 모른다. 
	// (ProductJdbcDao인지? ProductMybatisDao인지?)
	// Container 실행시 자신이 사용할 객체가 결정된다. (실행시점에 객체 결정)
	// Service의 코드를 바꾸지 않아도 된다.
	private ProductDao dao;
	
	// 2. setter 메소드 생성
	public void setDao(ProductDao dao) {
		System.out.println("조립되는 객체: " + dao);
		this.dao = dao;
	}

	public void 신규상품등록() {
		dao.insertProduct();
	}
	
	public void 상품상세정보조회() {
		dao.getProduct();
	}
	
	public void 상품정보수정() {
		dao.updateProduct();
	}

}
