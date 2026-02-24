<?php

namespace app\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use app\models\Produkte;

/**
 * ProdukteSearch represents the model behind the search form of `app\models\Produkte`.
 */
class ProdukteSearch extends Produkte
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['ProduktID', 'Produktname', 'Produktkategorie'], 'safe'],
            [['Stueckpreis'], 'number'],
            [['LieferantenID'], 'integer'],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function scenarios()
    {
        // bypass scenarios() implementation in the parent class
        return Model::scenarios();
    }

    /**
     * Creates data provider instance with search query applied
     *
     * @param array $params
     * @param string|null $formName Form name to be used into `->load()` method.
     *
     * @return ActiveDataProvider
     */
    public function search($params, $formName = null)
    {
        $query = Produkte::find();

        // add conditions that should always apply here

        $dataProvider = new ActiveDataProvider([
            'query' => $query,
        ]);

        $this->load($params, $formName);

        if (!$this->validate()) {
            // uncomment the following line if you do not want to return any records when validation fails
            // $query->where('0=1');
            return $dataProvider;
        }

        // grid filtering conditions
        $query->andFilterWhere([
            'Stueckpreis' => $this->Stueckpreis,
            'LieferantenID' => $this->LieferantenID,
        ]);

        $query->andFilterWhere(['like', 'ProduktID', $this->ProduktID])
            ->andFilterWhere(['like', 'Produktname', $this->Produktname])
            ->andFilterWhere(['like', 'Produktkategorie', $this->Produktkategorie]);

        return $dataProvider;
    }
}
