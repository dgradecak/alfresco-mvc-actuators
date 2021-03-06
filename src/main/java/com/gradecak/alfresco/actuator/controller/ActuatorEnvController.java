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

import org.springframework.boot.actuate.env.EnvironmentEndpoint;
import org.springframework.boot.actuate.env.EnvironmentEndpoint.EnvironmentDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/env")
public class ActuatorEnvController {

	private final EnvironmentEndpoint endpoint;
	private final ObjectMapper mapper;

	public ActuatorEnvController(EnvironmentEndpoint e, ObjectMapper mapper) {
		this.endpoint = e;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<?> get(@Nullable String pattern) throws IOException {
		EnvironmentDescriptor environment = endpoint.environment(pattern);
		return ResponseEntity.ok(mapper.writeValueAsString(environment));
	}

	@DeleteMapping
	public ResponseEntity<?> delete() {
		return ResponseEntity.badRequest().build();
	}

	@PostMapping
	public ResponseEntity<?> update() {
		return ResponseEntity.badRequest().build();
	}
}
