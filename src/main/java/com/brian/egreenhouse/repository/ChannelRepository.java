package com.brian.egreenhouse.repository;

import com.brian.egreenhouse.domain.Channel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends ReactiveCrudRepository<Channel, Integer> {

}
