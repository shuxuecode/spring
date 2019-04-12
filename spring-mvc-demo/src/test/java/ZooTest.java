import org.apache.zookeeper.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by QDHL on 2017/10/16.
 */
public class ZooTest {

    ZooKeeper zk = null;

    @Before
    public void before() {
        try {
            zk = new ZooKeeper("localhost:2181", 1000, new Watcher() {
                public void process(WatchedEvent event) {
                    System.out.println();
                    System.out.println("已经触发了" + event.getType() + "事件！");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
// 关闭连接
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws KeeperException, InterruptedException {
// 创建一个目录节点
//        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                CreateMode.PERSISTENT);
        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath", false, null)));
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath", true));
    }


    @Test
    public void test6() throws KeeperException, InterruptedException {
        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
        System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true) + "]");
    }

    @Test
    public void test2() throws KeeperException, InterruptedException {
        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", true, null)));
    }

    @Test
    public void test3() throws KeeperException, InterruptedException {
        // 删除子目录节点
        zk.delete("/testRootPath/testChildPathTwo",-1);
        zk.delete("/testRootPath/testChildPathOne",-1);
    }

    @Test
    public void test4() throws KeeperException, InterruptedException {
        // 删除父目录节点
        zk.delete("/testRootPath",-1);
    }

    @Test
    public void test5() throws KeeperException, InterruptedException {
        byte[] data = zk.getData("/", false, null);
        System.out.println(new String(data));
    }


}
