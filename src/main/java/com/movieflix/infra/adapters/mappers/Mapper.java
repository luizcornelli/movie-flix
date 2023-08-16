package com.movieflix.infra.adapters.mappers;

import java.util.List;

public interface Mapper<A, B>{
	B map(A input);
}
