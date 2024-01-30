using System.ComponentModel.DataAnnotations;

namespace MaesEmAcao_api.Models
{
    public class Candidato
    {
        [Key]
        public int id { get; set; }
        public string cpf { get; set; }
        public DateTime dataNascimento { get; set; }
        public string email { get; set; }
        public string formacao { get; set; }
        public string idioma { get; set; }
        public string nome { get; set; }
        public int qtdFilhos { get; set; }
        public string telefone { get; set; }
        public string endereco { get; set; }

    }
}
