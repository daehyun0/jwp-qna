package qna.domain;

import java.util.List;
import java.util.Objects;

import qna.CannotDeleteException;

public class Answers {
	private final List<Answer> answers;

	public Answers(List<Answer> answers) {
		this.answers = answers;
	}

	public boolean haveNotOwner(User loginUser) {
		return answers.stream()
			.anyMatch(answer -> !answer.isOwner(loginUser));
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setDeleted(boolean isDelete) {
		for (Answer answer: answers) {
			answer.setDeleted(isDelete);
		}
	}

	public void delete(User loginUser) throws CannotDeleteException {
		for (Answer answer: answers) {
			answer.delete(loginUser);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Answers answers1 = (Answers)o;
		return Objects.equals(answers, answers1.answers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(answers);
	}
}
