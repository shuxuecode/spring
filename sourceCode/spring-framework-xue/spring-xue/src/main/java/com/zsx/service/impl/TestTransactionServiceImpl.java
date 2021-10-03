package com.zsx.service.impl;

import com.zsx.service.TestTransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;


/**
 * spring事务测试
 */
@Service
public class TestTransactionServiceImpl implements TestTransactionService {

	@Override
	@Transactional
	public String testTransaction(Integer num) {

		// todo 测试失败
		// No qualifying bean of type 'org.springframework.transaction.TransactionManager' available

		boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
		System.out.println("synchronizationActive : " + synchronizationActive);

		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
			@Override
			public void afterCompletion(int status) {
				System.out.println("事务status=" + status);
				if (TransactionSynchronization.STATUS_COMMITTED == status) {
					// 事务成功了
				} else if (TransactionSynchronization.STATUS_ROLLED_BACK == status) {
					// 事务回滚
				}
			}
		});


		if (num == null) {
			//throw new Exception("参数为空");
		}


		if (num == 1) {
			return "参数是1";
		}

		if (num == 2) {
			return "参数是2";
		}


		return "其它情况";
	}
}
