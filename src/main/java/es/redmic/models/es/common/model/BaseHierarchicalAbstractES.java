package es.redmic.models.es.common.model;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 11:55:18
 */
public abstract class BaseHierarchicalAbstractES extends BasePathAbstractES {

	private Integer leaves;

	public BaseHierarchicalAbstractES() {
		super();
	}

	public Integer getLeaves() {
		return leaves;
	}

	public void setLeaves(Integer leaves) {
		this.leaves = leaves;
	}

	
}