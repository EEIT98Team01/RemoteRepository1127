package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Classfication")
public class ClassficationBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classficationID;
	private String classficatoinName;
	private String classificationDescription;
	private boolean startStopStatus;

	@Override
	public String toString() {
		return "ClassficationBean [classficationID=" + classficationID + ", classficatoinName=" + classficatoinName
				+ ", classificationDescription=" + classificationDescription + ", startStopStatus=" + startStopStatus
				+ "]";
	}

	public int getClassficationID() {
		return classficationID;
	}

	public void setClassficationID(int classficationID) {
		this.classficationID = classficationID;
	}

	public String getClassficatoinName() {
		return classficatoinName;
	}

	public void setClassficatoinName(String classficatoinName) {
		this.classficatoinName = classficatoinName;
	}

	public String getClassificationDescription() {
		return classificationDescription;
	}

	public void setClassificationDescription(String classificationDescription) {
		this.classificationDescription = classificationDescription;
	}

	public boolean isStartStopStatus() {
		return startStopStatus;
	}

	public void setStartStopStatus(boolean startStopStatus) {
		this.startStopStatus = startStopStatus;
	}

}
