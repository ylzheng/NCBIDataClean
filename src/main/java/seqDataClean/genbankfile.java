package seqDataClean;

/**
 * Created by yqb7 on 5/6/16.
 */
/**This file function is load the genbank file and save the details*/
public class genbankfile {
    public String locus;
    public String definition;
    public String accession;
    public String version;
    public String giNumber;
    public String keyWords;
    public String sourceOrganism;
    public String organism;
    public String reference;
    public String authors;
    public String title;
    public String journal;
    public String comment;
    public String feature;
    public String sourceFeature;
    public String originSequence;
    public genbankfile(){}
    public genbankfile(String locus,
            String definition, String accession, String version, String giNumber, String keyWords,
            String sourceOrganism, String organism, String reference, String authors, String title,
            String journal, String comment, String feature, String sourceFeature, String originSequence){
        this.locus = locus;
        this.definition = definition;
        this.accession = accession;
        this.version = version;
        this.giNumber = giNumber;
        this.keyWords = keyWords;
        this.sourceOrganism = sourceOrganism;
        this.organism = organism;
        this.reference = reference;
        this.authors = authors;
        this.title = title;
        this.journal = journal;
        this.comment = comment;
        this.feature = feature;
        this.sourceFeature =sourceFeature;
        this.originSequence = originSequence;


    }
}
