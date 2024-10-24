package com.example.sbdb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.sbdb.dto.Product;
import com.example.sbdb.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
public class AddProductTest {
	@Mock
	MockMvc mockMvc;
	@Mock
	ProductService productService;
	private String productJson ="{\r\n"
			+ "  \"productName\": \"Chiku\",\r\n"
			+ "  \"productId\": 107,\r\n"
			+ "  \"quantity\": \"10\"\r\n"
			+ "}";


	@Test
	public void testAddProduct() throws Exception {
		Product product = new Product();
		product.setProductId(5);
		product.setProductName("APPLe");
		product.setQuantity("10");
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper()
						.writeValueAsString(product))).andReturn();

		assertEquals(201, mvcResult.getResponse().getStatus());
	}

	/*

	 @Test
	void addProduct() {
		// studentService.addCourse to respond back with mockCourse

		Product product = new Product();
		product.setProductId(5);
		product.setProductName("APPLe");
		product.setQuantity("10");



		String urlStr = "http://localhost:8080/add";
		//String soap_req_msg="{\"billerid\": \"RELENG\",\"short_name\": \"HOME1\", \"authenticators\": [{\"parameter_name\": \"Consumer number\",\"value\": \"555555556\"}],\"customer\": {\"customer_name\": \"AG Test Two\",\"customer_mobile\": \"9988776655\",\"customer_email\": \"agtest2@billdesk.com\",\"customer_pan\": \"AEPM123RC6\",\"customer_aadhaar\": \"1223123123\"},\"metadata\": {\"agent\": {\"agentid\": \"BD001MPY100000100001\",\"sub_agentid\": \"BD001MPY11\"},\"device\": {\"mobile\": \"9800000000\",\"geocode\": \"19.075984,72.877656\",\"postal_code\": \"400053\",\"ip\": \"124.124.1.1\",\"init_channel\": \"INT\",\"branch_code\": \"UTI00035\",\"terminalid\": \"123123\",\"imei\": \"123123123\",\"mac\": \"11-AC-58-21-1B-AA\",\"os\": \"iOS\",\"app\": \"AGENTAPP\",\"user_agent\": \"Mozilla/5.0 (Windows NT 6.3; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0\",\"device_fingerprint\": \"AB22331DF49A\"}}}";
		InputStream in = null;
		URL url = null;
		URLConnection urlConnection = null;
		HttpURLConnection httpurlconnection = null;
		BufferedReader lo_in = null;
		StringBuffer respbuf = new StringBuffer();
		String inputLine = null;
		try {

	 * System.out .println("Start[" + new
	 * SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "]  url=" +
	 * urlStr); System.out.println( "Start[" + new
	 * SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) +
	 * "]  request message=" + urlStr);


			url = new URL(urlStr);
			urlConnection = url.openConnection();
			httpurlconnection = (HttpURLConnection) urlConnection;
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.addRequestProperty("Content-type", "APPLICATION_JSON");
			httpurlconnection.setRequestProperty("Accept", "APPLICATION_JSON");
			httpurlconnection.setConnectTimeout(10000);
			httpurlconnection.setReadTimeout(120000);
			//POST CODE

			OutputStream out = httpurlconnection.getOutputStream();
			Writer wout = new OutputStreamWriter(out);
			wout.write(productJson);
			wout.flush();
			wout.close();

			System.out.println("waiting for the response....");
			if (httpurlconnection.getResponseCode() == 200) {
				in = httpurlconnection.getInputStream();
				lo_in = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
				while ((inputLine = lo_in.readLine()) != null) {
					respbuf.append(inputLine);
				}
			} else if (httpurlconnection.getResponseCode() == 500) {
				respbuf.setLength(0);
				respbuf.append("HTTP_SOC_TIMEOUT");
			} else {
				respbuf.setLength(0);
				respbuf.append("HTTP_SOC_TIMEOUT");
			}
			System.out.println(respbuf);

		} catch (Exception e) {
			e.printStackTrace();
			if ("Read timed out".equalsIgnoreCase(e.getMessage())) {
				respbuf.setLength(0);
				respbuf.append("HTTP_SOC_TIMEOUT");
			}
		} finally{
			try {
				System.out.println("http response code=" + httpurlconnection.getResponseCode());
				if (in != null)
					in.close();
				if (lo_in != null)
					lo_in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(respbuf.toString());


	}*/

}
