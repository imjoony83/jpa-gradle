package com.github.imjoony83.jpagradle.service;

import com.github.imjoony83.jpagradle.repository.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerJpaRepository customerJpaRepository;


}
