public class PdfInvoiceService implements InvoiceService{
    @Override
    public void generateInvoice(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name must not be blank.");
        }
        System.out.println("PDF invoice generated: " + fileName);
    }
}
