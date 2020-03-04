/**
 * Copyright gradecak.com

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gradecak.alfresco.actuator.module;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mvc-actuators")
public class MvcActuatorsProperties {

	private Map<String, Object> info = Collections.emptyMap();
	private Jolokia jolokia = new Jolokia();
	private Alfresco alfresco = new Alfresco();

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public Jolokia getJolokia() {
		return jolokia;
	}

	public void setJolokia(Jolokia jolokia) {
		this.jolokia = jolokia;
	}

	public Alfresco getAlfresco() {
		return alfresco;
	}

	public void setAlfresco(Alfresco alfresco) {
		this.alfresco = alfresco;
	}

	public static class Jolokia {
		private boolean enabled = true;

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
	}

	public static class Alfresco {
		private boolean mbeansEnabled = true;

		public boolean isMbeansEnabled() {
			return mbeansEnabled;
		}
		
		public void setMbeansEnabled(boolean mbeansEnabled) {
			this.mbeansEnabled = mbeansEnabled;
		}
	}
}