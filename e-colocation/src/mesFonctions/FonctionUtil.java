package mesFonctions;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import beans.PhotoPropriete;
import beans.Propriete;
import beansManager.ManagerPhotoPropriete;
import beansManager.ManagerPropriete;

public class FonctionUtil {
	
	public static boolean uploadPhotoPropriete(HttpServletRequest request,int id_proprietaire) {
		
		/*
		 * IMPORTANT A LIRE
		 * Requiremet les deux jar "commons and org.apache"
		 * On s'insterse pas au nom des input car on test sur tous 
		 * y'a pa de probleme des espaces
		 * 
		 * */
		
		/*
		 * Warning 
		 * j'ai changer la comportement de cet fonction pour qu'il s'applique 
		 * uniquement sur les photos de la propriete
		 * */
		
		Propriete pro = new Propriete();
		String images[] = new String[3];
		int i = 0;
		boolean statut = false;
		

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			return false;
		}
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			/* Test : est ce qu'il y a des input dans la form 
			 * On recupere tous les input
			 * */
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				return false;
			}
			/* on boucle sur les inputs pour trouver l'input correspadant a notre fichier
			 * On
			 * */
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (!isFormField) {
					if (fileItem.getSize() > 0) {
						/* fileItem.getName() conteint le nom de fichier */
						fileItem.write(new File("C:/eclipse_workSpace/e-colocation/WebContent/presentation/assets/img/maison/" + fileItem.getName()));
						
						/* recuperer les chemins des images et les mettre dans un tableau*/
						images[i++] = new String(fileItem.getName());
						
						statut = true;
					}
				}
				else{
					switch(fileItem.getFieldName()) {
					case "code":
						pro.setCode(fileItem.getString());
						break;
					case "adresse":
						pro.setAddresse(fileItem.getString());
						break;
					case "ville":
						pro.setVille(fileItem.getString());
						break;
					case "superficie":
						pro.setSuperficie(Integer.parseInt(fileItem.getString()));
						break;
					case "type":
						pro.setType(fileItem.getString());
						break;
					case "prix":
						pro.setPrix(Integer.parseInt(fileItem.getString()));
						break;
					case "nbMax":
						pro.setNbMax(Integer.parseInt(fileItem.getString()));
						break;
					case "nbSouhaite":
						pro.setNbSouhaite(Integer.parseInt(fileItem.getString()));
						break;
					case "disponibilite":
						pro.setDisponibilite(fileItem.getString());
						break;							
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*Insertion de la photo dans la base de donnees*/
		pro.setId_proprietaire(id_proprietaire);
		ManagerPropriete mngP = new ManagerPropriete();
		mngP.fct_insert(pro);
		int id = mngP.fct_getMaxIdPorpriete();
		
		PhotoPropriete pp = new PhotoPropriete();
		pp.setId_pro(id);
		for(int j=0;j<images.length;j++) {
			pp.setChemin(images[j]);
			ManagerPhotoPropriete mngPP = new ManagerPhotoPropriete();						
			mngPP.fct_insert(pp);
		}
		
		return statut;
	}

}
