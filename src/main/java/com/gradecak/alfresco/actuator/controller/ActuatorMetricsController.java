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

package com.gradecak.alfresco.actuator.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint.MetricResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/metrics")
public class ActuatorMetricsController {

	private final MetricsEndpoint endpoint;
	private final ObjectMapper mapper;

	public ActuatorMetricsController(MetricsEndpoint endpoint, ObjectMapper mapper) {
		this.endpoint = endpoint;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<?> get() throws IOException {
		return ResponseEntity.ok(mapper.writeValueAsString(endpoint.listNames()));
	}

	@GetMapping("{metricName:.+}")
	public ResponseEntity<?> metric(@PathVariable String metricName, @RequestParam(required = false) List<String> tag)
			throws IOException {
		MetricResponse metric = endpoint.metric(metricName, tag);
		return ResponseEntity.ok(metric);
	}

}
