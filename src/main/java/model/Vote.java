package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Vote.GET_ALL_VOTES_QUERY_NAME, query="SELECT v FROM Vote v")
@NamedQuery(name=Vote.GET_ALL_VOTES_IDS_QUERY_NAME, query="SELECT v.id FROM Vote v")
@NamedQuery(name=Vote.GET_ALL_VOTES_IDS_BY_QUESTION_ID_QUERY_NAME, query="SELECT v.id FROM Vote v WHERE v.question.id= :id")
@NamedQuery(name=Vote.GET_VOTES_COUNT_BY_QUESTION_ID_QUERY_NAME, query="SELECT COUNT(v.id) FROM Vote v WHERE v.question.id= :id")
@NamedQuery(name=Vote.GET_ALL_VOTES_TIME, query="SELECT v.createdAt FROM Vote v")
@NamedQuery(name=Vote.GET_ALL_NEW_VOTES, query="SELECT v FROM Vote v WHERE v.createdAt > :time")
public class Vote extends GenericEntity {

	private static final long serialVersionUID = 1L;

	public static final String GET_ALL_VOTES_QUERY_NAME="Vote.getAllVotes";
	public static final String GET_ALL_VOTES_IDS_QUERY_NAME="Vote.getAllVotesIds";
	public static final String GET_ALL_VOTES_IDS_BY_QUESTION_ID_QUERY_NAME="Vote.getAllVotesIdsByQuestionId";
	public static final String GET_VOTES_COUNT_BY_QUESTION_ID_QUERY_NAME="Vote.getVotesCountByQuestionId";
	public static final String GET_ALL_VOTES_TIME="Vote.getAllVotesTime";
	public static final String GET_ALL_NEW_VOTES="Vote.getAllNewVotes";
	
	@ManyToOne
	private Question question;

	public static Long lastUpdate;
	private Long createdAt;
	
	public Vote() {
		
	}
	
	public Vote(Question question) {
	
		super();
		this.question = question;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "Vote [question=" + question + "]";
	}

}
