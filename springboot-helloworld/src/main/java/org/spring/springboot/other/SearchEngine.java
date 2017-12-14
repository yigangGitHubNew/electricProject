package org.spring.springboot.other;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

/**
 * java 的搜索引擎的使用（基于内存）
 * @author yigang.wu 2017年9月18日
 *
 */
public class SearchEngine {
	 /**
     * 创建索引
     * 
     * @param sourceMap
     *            待索引的内容
     * @return
     */
    public static Directory createIndex(Map<String, String> sourceMap) {
        //1 创建一个默认的词法分析器
        Analyzer analyzer = new StandardAnalyzer();
 
        //2 设置索引文件存储位置，可以存储到磁盘和内存中，这里设置为存储到内存
        Directory directory = new RAMDirectory(); // 存储到内存
 
        //3 索引的写入
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        try {
            IndexWriter indexWriter = new IndexWriter(directory, config);
 
            //将内容添加到索引中，每本书表示一个“文档”，并将每个文档进行存储
            if (!sourceMap.isEmpty()) {
                for (Entry<String, String> source : sourceMap.entrySet()) {
                    Document document = new Document();
                    //标题需要分词，使用TextField
                    document.add(new TextField("title", source.getKey(), Store.YES));
                    //作者不需要分词，使用StringField
                    document.add(new StringField("author", source.getValue(), Store.YES));
                    indexWriter.addDocument(document);
                }
            }
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return directory;
    }
 
    /**
     * 搜索
     * 
     * @param directory
     * @param searchWord
     *            搜索关键词
     * @throws ParseException 
     */
    public static void readIndex(Directory directory, String searchWord) throws ParseException {
        int preHits = 10; //获取前面多少个结果
 
        try {
            //1 打开一个文档
            IndexReader indexReader = DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            Analyzer analyzer = new StandardAnalyzer();
 
            //2 设置使用关键字检索，这里是检索标题
            QueryParser parser = new QueryParser("title", analyzer);
            Query query = parser.parse(searchWord);
 
            //3 获取检索到的结果
            System.out.println("总共有 " + indexSearcher.count(query) + " 个结果");
            ScoreDoc[] hits = indexSearcher.search(query, preHits).scoreDocs;
 
            System.out.println("当前有 " + hits.length + " 个结果，内容分别如下：");
            //遍历检索到的“文档”
            for (int i = 0; i < hits.length; i++) {
                int docId = hits[i].doc;
                Document hitDoc = indexSearcher.doc(docId);
                System.out.println("《 " + hitDoc.get("title") + "》    作者： " + hitDoc.get("author"));
            }
            indexReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) throws ParseException {
        Map<String, String> books = new HashMap<String, String>();
        books.put("Java编程思想", "Bruce Eckel");
        books.put("Java8实战", "Raoul-Gabriel Urma");
        books.put("Spring入门经典", "Mert Caliskan");
        books.put("Spring实战", "Craig Walls");
        books.put("Spring Boot实战", "汪云飞");
        books.put("Redis实战", "Josiah L. Carlson");
 
        Directory directory = SearchEngine.createIndex(books);
        SearchEngine.readIndex(directory, "Spring");
//      SearchEngine.readIndex(directory, "实战");
    }
}
