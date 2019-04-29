//package com.asiainfo.rms.alm.configure;
//
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.FactoryBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//@Configuration
//public class ElasticSearchConfigure implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {
//
//    public static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfigure.class);
//
//    @Value("${spring.data.elasticsearch.cluster-nodes}")
//    private String clusterNodes ;
//
//    @Value("${spring.data.elasticsearch.cluster-name}")
//    private String clusterName;
//
//    private TransportClient client;
//
//    @Override
//    public TransportClient getObject() throws Exception {
//        return client;
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        try {
//            logger.info("Closing elasticSearch client");
//            if (client != null) {
//                client.close();
//            }
//        } catch (final Exception e) {
//            logger.error("Error closing ElasticSearch client: ", e);
//        }
//    }
//
//
//    @Override
//    public Class<?> getObjectType() {
//        return TransportClient.class;
//    }
//
//    @Override
//    public boolean isSingleton() {
//        return false;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        buildClient();
//    }
//
//
//
//    protected void buildClient()  {
//        try {
//            PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(settings());
//            if (!"".equals(clusterNodes)){
//                for (String nodes:clusterNodes.split(",")) {
//                    String InetSocket [] = nodes.split(":");
//                    String  Address = InetSocket[0];
//                    Integer  port = Integer.valueOf(InetSocket[1]);
//                    preBuiltTransportClient.addTransportAddress(new
//                            InetSocketTransportAddress(InetAddress.getByName(Address),port ));
//                }
//                client = preBuiltTransportClient;
//            }
//        } catch (UnknownHostException e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//    private Settings settings(){
//        Settings settings = Settings.builder()
//                .put("cluster.name",clusterName)
//                .put("client.transport.sniff",true)
//                .build();
//        client = new PreBuiltTransportClient(settings);
//        return settings;
//    }
//}
