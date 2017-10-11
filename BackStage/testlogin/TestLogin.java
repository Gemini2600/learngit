import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.AccProductDao;
import com.neusoft.dao.AccountDao;
import com.neusoft.dao.AddressDao;
import com.neusoft.dao.CateDao;
import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.OrderDao;
import com.neusoft.dao.ProductDao;
import com.neusoft.dao.RuleDao;
import com.neusoft.dao.impl.AccProductDaoImpl;
import com.neusoft.dao.impl.AccountDaoImpl;
import com.neusoft.dao.impl.AddressDaoImpl;
import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.dao.impl.ConsumerDaoImpl;
import com.neusoft.dao.impl.OrderDaoImpl;
import com.neusoft.dao.impl.ProductDaoImpl;
import com.neusoft.dao.impl.RuleDaoImpl;
import com.neusoft.entity.Account;
import com.neusoft.entity.Address;
import com.neusoft.entity.Cate;
import com.neusoft.entity.Consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.DbUtil;

public class TestLogin {
	public static void main(String[] args) {
//		testDoLogin();
//		testUpdate();
//		testcheckCateList();
//		testGetPageModel();
//		testAddCate();
//		testUpdateCate();
//		testGetPageModelP();
//		testGetProductList();
//		testDeleteProduct();
//		updata();
//		testGetRuleList();
//		testGetConsumerList();
//		testAddConsumer();
//		testGetPageModelOrder();
//		testGetAccProduct();
//		testGetPageModelStatus();
//		testGetPageModelAddress();
		testGetAddressList();
	}
	public  static void testDoLogin(){
		AccountDao	ad=DbUtil.getInstance("accountDao", AccountDaoImpl.class);
		Account acc=ad.doLogin("admin", "admin");
		System.out.println(acc);
	}
	
	public static void testUpdate(){
		AccountDao	ad=DbUtil.getInstance("accountDao", AccountDaoImpl.class);
		
		boolean flag=ad.update(new Account(1,"admin","admin","127.0.0.2",System.currentTimeMillis()));
		System.out.println(flag);
	}
	
	public static void testcheckCateList(){
		CateDao	cd=DbUtil.getInstance("cateDao", CateDaoImpl.class);
		List<Cate> cateList=cd.checkCateList();
		for (Cate cate : cateList) {
			System.out.println(cate);
		}
	}
	//测试分页
	public static void testGetPageModel(){
		CateDao	cd=DbUtil.getInstance("cateDao", CateDaoImpl.class);
		PageModel<Cate> pageModel=cd.getPageModel(1, 3);
		System.out.println(pageModel);
	}
	//测试添加
	public static void testAddCate(){
		CateDao	cd=DbUtil.getInstance("cateDao", CateDaoImpl.class);
		boolean flag=cd.addCate(new Cate("短袖",101));
		System.out.println(flag);
	}
	//测试修改
	public static void testUpdateCate(){
		CateDao	cd=DbUtil.getInstance("cateDao", CateDaoImpl.class);
		boolean flag=cd.updateCate(new Cate(130,"ASD",103));
		System.out.println(flag);
	}
	//测试商品分页
	public static void testGetPageModelP(){
		ProductDao pd=DbUtil.getInstance("productDao", ProductDaoImpl.class);
		PageModel<Product> pageModel=pd.getPageModel(1, 1);
		System.out.println(pageModel);
		
	}
	//查询全部商品
	public static void testGetProductList(){
		ProductDao pd=DbUtil.getInstance("productDao", ProductDaoImpl.class);
		List<Product> productList=pd.getProductList();
		System.out.println(productList);
	}
	//删除商品
	public static void testDeleteProduct(){
		ProductDao pd=DbUtil.getInstance("productDao", ProductDaoImpl.class);
		System.out.println(pd.deleteProduct(1));
	}
	//修改商品
	public static void updata(){
		ProductDao pd=DbUtil.getInstance("productDao", ProductDaoImpl.class);
		System.out.println(pd.updateProduct(new Product(15, "wa", 1, "0", "oo", 20.00, 1, "iei")));
	}
	//测试查看规格
	public static void testGetRuleList(){
		RuleDao rd=DbUtil.getInstance("ruleDao", RuleDaoImpl.class);
		System.out.println(rd.getRuleList());
	}
	//测试会员
	public static void testGetConsumerList(){
		ConsumerDao cd=DbUtil.getInstance("consumerDao", ConsumerDaoImpl.class);
		System.out.println(cd.getConsumerList());
	}
	//测试添加会员
	public static void testAddConsumer(){
		ConsumerDao cd=DbUtil.getInstance("consumerDao", ConsumerDaoImpl.class);
		System.out.println(cd.addConsumer(new Consumer("jsp2","12345",2017,2017,"10.25.151.170")));
	}
	//测试订单
	public static void testGetPageModelOrder(){
		OrderDao od=DbUtil.getInstance("orderDao", OrderDaoImpl.class);
		System.out.println(od.getPageModel(1,2));
	}
	//测试卖家id
	public static void testGetAccProduct(){
		AccProductDao apd=DbUtil.getInstance("accProductDao", AccProductDaoImpl.class);
		System.out.println(apd.getAccProduct(3));
	}
	//测试不同订单状态
	public static void testGetPageModelStatus(){
		OrderDao od=DbUtil.getInstance("orderDao", OrderDaoImpl.class);
		System.out.println(od.getPageModelStatus(1, 4, 2));
	}
	//测试地址分页
	public static void testGetPageModelAddress(){
		AddressDao  ad=DbUtil.getInstance("addressDao", AddressDaoImpl.class);
		System.out.println(ad.getPageModel(1, 2));
	}
	//测试查询全部地址
	public static void testGetAddressList(){
		AddressDao  ad=DbUtil.getInstance("addressDao", AddressDaoImpl.class);
		List<Address> addresss=ad.getAddressList();
		System.out.println(addresss);
	}
}
