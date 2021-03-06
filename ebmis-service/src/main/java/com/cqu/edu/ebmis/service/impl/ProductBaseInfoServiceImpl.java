/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;
import com.cqu.edu.ebmis.repository.ProductBaseInfoRepository;
import com.cqu.edu.ebmis.service.ProductBaseInfoService;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 产品基本信息服务实现
 * 
 * @author mxl
 * @version $ ProductBaseInfoServiceImpl.java v1.0, 2017年5月5日 下午11:30:09 mxl Exp
 *          $
 */
@Service
public class ProductBaseInfoServiceImpl implements ProductBaseInfoService {
	
	@Autowired
	private ProductBaseInfoRepository	productBaseInfoRepository;
	
	/**
	 * @see com.cqu.edu.ebmis.service.ProductBaseInfoService#delete(long)
	 */
	public int delete(long productInnerId) {
	
		return productBaseInfoRepository.deleteByPrimaryKey(productInnerId);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.ProductBaseInfoService#selectByInnerId(long)
	 */
	public ProductBaseInfoDO selectByInnerId(long productInnerId) {
	
		return productBaseInfoRepository.selectByPrimaryKey(productInnerId);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.ProductBaseInfoService#update(long, int,
	 *      int)
	 */
	public int update(long productInnerId, int checked, int isValid) {
	
		// 捞取产品数据
		ProductBaseInfoDO product = productBaseInfoRepository
				.selectByPrimaryKey(productInnerId);
		
		if (product != null) {
			
			product.setChecked(checked);
			
			product.setIsValid(isValid);
			
			return productBaseInfoRepository.update(product);
		} else {
			
			return 0;
		}
		
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.ProductBaseInfoService#findAllProduct()
	 */
	public List<ProductBaseInfoDO> findAllProduct() {
	
		return productBaseInfoRepository.selectAllProduct();
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.ProductBaseInfoService#findByPage(com.cqu.edu.ebmis.service.page.Page)
	 */
	public Page<ProductBaseInfoDO> findByPage(Page<ProductBaseInfoDO> page) {
	
		List<ProductBaseInfoDO> keyWords = productBaseInfoRepository
				.selectByPage(page.getLimit() , page.getOffset());
		page.setTotal(productBaseInfoRepository.selectCount());
		
		page.setRecords(keyWords);
		return page;
	}
	
}
