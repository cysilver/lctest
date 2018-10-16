package pt.cysilver.test2imp.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Exchange {
	/*
	 * {"userId": "134256", 
 "currencyFrom": "EUR", 
 "currencyTo": "GBP", 
 "amountSell": 1000, 
"amountBuy": 747.10, 
 "rate": 0.7471, 
 "timePlaced" : "24-JAN-15 10:27:44", 
 "originatingCountry": "FR"}
	 */
	
	private String userId;
	private String currencyFrom;
	private String currencyTo;
	private Double amountSell;
	private Double amountBuy;
	private Double rate;
	@JsonFormat
	(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy hh:mm:ss")
	private Date timePlaced;
	private String originatingCountry;
	
	public Exchange() {
		userId = "134256";
		currencyFrom = "EUR"; 
		currencyTo = "GBP"; 
		amountSell = 1000.0; 
		amountBuy = 747.10; 
		rate = 0.7471;
		//timePlaced = new GregorianCalendar();
		originatingCountry = "FR";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public Double getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(Double amountSell) {
		this.amountSell = amountSell;
	}

	public Double getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(Double amountBuy) {
		this.amountBuy = amountBuy;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Date getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public String toString() {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
}
