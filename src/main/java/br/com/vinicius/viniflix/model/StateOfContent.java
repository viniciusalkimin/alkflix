package br.com.vinicius.viniflix.model;

import javax.persistence.Embeddable;

@Embeddable
public enum StateOfContent {
	FINISHED, INICIALIZED, UNINITIALIZED;

}
