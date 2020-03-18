package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_COMMENT")

public class Comment implements Serializable{

			private static final long serialVersionUID = 1L;

			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int IdComment;
			
			private String DescriptionComment;
			private int NumberLikes;
			
			private Boolean IsBlocked;
			
			@ManyToOne
			private Ad ad;

			public int getIdComment() {
				return IdComment;
			}

			public void setIdComment(int idComment) {
				IdComment = idComment;
			}

			public String getDescriptionComment() {
				return DescriptionComment;
			}

			public void setDescriptionComment(String descriptionComment) {
				DescriptionComment = descriptionComment;
			}

			public int getNumberLikes() {
				return NumberLikes;
			}

			public void setNumberLikes(int numberLikes) {
				NumberLikes = numberLikes;
			}

			public Boolean getIsBlocked() {
				return IsBlocked;
			}

			public void setIsBlocked(Boolean isBlocked) {
				IsBlocked = isBlocked;
			}

			public Ad getAd() {
				return ad;
			}

			public void setAd(Ad ad) {
				this.ad = ad;
			}

			public static long getSerialversionuid() {
				return serialVersionUID;
			}

			public Comment() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Comment(String descriptionComment, int numberLikes, Boolean isBlocked, Ad ad) {
				super();
				DescriptionComment = descriptionComment;
				NumberLikes = numberLikes;
				IsBlocked = isBlocked;
				this.ad = ad;
			}

			@Override
			public String toString() {
				return "Comment [IdComment=" + IdComment + ", DescriptionComment=" + DescriptionComment
						+ ", NumberLikes=" + NumberLikes + ", IsBlocked=" + IsBlocked + ", ad=" + ad + "]";
			}
			

}
