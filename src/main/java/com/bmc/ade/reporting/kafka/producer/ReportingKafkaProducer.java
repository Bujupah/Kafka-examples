/**
 * 
 */
package com.bmc.ade.reporting.kafka.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.producer.internals.FutureRecordMetadata;

import com.bmc.ade.reporting.usermanagement.dto.ADEService;
import com.bmc.ade.reporting.usermanagement.dto.TMSEvent;
import com.bmc.ade.reporting.usermanagement.dto.TMSServiceActivationEvent;
import com.bmc.ade.reporting.usermanagement.dto.Tenant;
import com.bmc.ade.reporting.usermanagement.dto.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author abjadhav
 *
 */
public class ReportingKafkaProducer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Properties properties = new Properties();
	        properties.put("bootstrap.servers", "vl-aus-ade-dv16.bmc.com:9092");
	        //properties.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
	        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	        properties.put("value.serializer", "org.apache.kafka.connect.json.JsonSerializer");
	        properties.put("group.id", "reporting-tms");
	        KafkaProducer<String, JsonNode> kafkaProducer = new KafkaProducer(properties);
	        try{
	            /*for(int i = 0; i < 100; i++){
	                System.out.println(i);
	                kafkaProducer.send(new ProducerRecord<String, String>("test", Integer.toString(i), "test message - " + i ));
	            }*/
	        	ObjectMapper mapper = new ObjectMapper();
	        	TMSEvent event = new TMSEvent();
	        	event.setType("TENANT_ACTIVATION_EVENT");
	        	Tenant tenant = new Tenant();
	        	tenant.setTenantId(37);
	        	tenant.setTenantName("Test999");
	        	event.setData(tenant);
	        	
	        	JsonNode jsonNode = mapper.valueToTree(event);
	        	System.out.println("JSON is: " + jsonNode.toPrettyString());
	        	Future<RecordMetadata> future = kafkaProducer.send(new ProducerRecord<String, JsonNode>("tms-tnsvcs-inbound", jsonNode));
	        	System.out.println("Data - " + future.toString());
	        	
	        	System.out.println("Sending Service activation event.");
	        	TMSEvent event1 = new TMSEvent();
	        	event1.setType("TENANT_SERVICE_ACTIVATED");
	        	ADEService service = new ADEService();
	        	service.setName("Monitor");
	        	TMSServiceActivationEvent tms = new TMSServiceActivationEvent();
	        	tms.setService(service);
	        	tms.setTenant(tenant);
	        	tms.setId("1");
	        	event1.setData(tms);
	        	
	        	jsonNode = mapper.valueToTree(event1);
	        	System.out.println("JSON is: " + jsonNode.toPrettyString());
	        	Future<RecordMetadata> future1 = kafkaProducer.send(new ProducerRecord<String, JsonNode>("jsonTopic", jsonNode));
	        	System.out.println("Data - " + future1.toString());
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	            kafkaProducer.close();
	        }
	}

}
