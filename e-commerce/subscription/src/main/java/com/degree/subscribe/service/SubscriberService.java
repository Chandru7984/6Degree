package com.degree.subscribe.service;

import com.degree.subscribe.dto.SubscriberDto;
import com.degree.subscribe.entity.Subscriber;

public interface SubscriberService {
	
	Subscriber saveSubscriber(SubscriberDto subscriberDto) throws Exception;

}
