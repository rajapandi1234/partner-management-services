package io.mosip.testrig.apirig.partner.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.mosip.testrig.apirig.partner.testrunner.MosipTestRunner;
import io.mosip.testrig.apirig.utils.ConfigManager;

public class PMSConfigManger extends ConfigManager{
	private static final Logger LOGGER = Logger.getLogger(PMSConfigManger.class);
	
	public static void init() {
		Map<String, Object> moduleSpecificPropertiesMap = new HashMap<>();
		// Load scope specific properties
		try {
			String path = MosipTestRunner.getGlobalResourcePath() + "/config/pms.properties";
			Properties props = getproperties(path);
			// Convert Properties to Map and add to moduleSpecificPropertiesMap
			for (String key : props.stringPropertyNames()) {
				moduleSpecificPropertiesMap.put(key, props.getProperty(key));
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		// Add module specific properties as well.
		init(moduleSpecificPropertiesMap);
	}
}